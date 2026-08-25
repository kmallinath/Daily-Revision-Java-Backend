import React, { useState } from "react";
import { IoChatbubblesOutline } from "react-icons/io5";
import DarkModeToggleSwitch from "./DarkModeToggleSwitch";
import { Toaster, toast } from "react-hot-toast";
import createRoomApi, { joinRoomApi } from "../services/RoomService";
import { useNavigate } from "react-router";
import userChatContext from "../context/ChatContext";

const JoinCreate = () => {

    const [details,setDetails]=useState({
        userName:"",
        roomId:""
    })

    const {roomId,setRoomId,connected,setConnected,userName,setUserName}= userChatContext();

    const navigate= useNavigate()



    function handleFormInputChange(event){
        
        setDetails({
            ...details,
            [event.target.name]:event.target.value,
        });

        console.log(details);

    }

    function validateInput()
    {
        if(details.userName=="" || details.roomId=="")
        {
            return false;
        }
        return true;
    }


    async function joinRoom()
    {
        if(!validateInput())
        {
            toast.error("Invalid Input.")
            return;
        }
        try{
            const response= await joinRoomApi(details.roomId);
            setUserName(details.userName)
            setRoomId(details.roomId)
            setConnected(true);
            navigate("/chat")
            toast.success("Joined Room")
           
        }
        catch{
            toast.error("Room does not Exist")
        }

       
    }

    async function  createRoom()
    {
        if(!validateInput())
        {
            toast.error("Invalid Input.")
            return;
        }
        try{
            const response= await createRoomApi(details.roomId);
            console.log(response)
            setConnected(true);
            setUserName(details.userName)
            setRoomId(response.roomId)
            // console.log(response.roomId +" "+ details.userName);
            toast.success("Room is created")
            navigate("/chat")
            
        }
        catch(error)
        {
            console.log(error);
            toast.error("Something is wrong. Please try agiain later")
        }
        return
    }

    return (
    
    <div className="min-h-screen flex items-center justify-center">

        
        <div className="text-base sm:text-xl md:text-2xl w-full max-w-md border-1 rounded-2xl p-6 md:p-6 dark:bg-gray-900" >
        <div className="flex justify-end mb-2">
            <DarkModeToggleSwitch />
        </div>
   
        <div className="flex align-center justify-center">
            <IoChatbubblesOutline className="text-5xl  sm:text-5xl md:text-6xl text-cyan-500 mr-3" />
     
            
            <h1 className="text-2xl sm:text-3xl md:text-4xl font-bold text-center mb-10">
                LETS CHAT
            </h1>
       </div>
            <div className="flex-col flex-wrap md:flex-nowrap gap-4">
            <label htmlFor="roomId" className="text-sm sm:text-sm md:text-sm" >Name</label>
            <input value={details.userName} onChange={handleFormInputChange} type="text" name="userName" id="userName" className="text-center h-6  w-full rounded-md border-1 border-cyan-600  shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm" placeholder="Enter Your Name" />
            </div>
            <div className="flex-col flex-wrap md:flex-nowrap gap-4">
            <label htmlFor="roomId" className="text-sm sm:text-sm md:text-sm" >Room ID</label>
            <input value={details.roomId} onChange={handleFormInputChange}  type="text" name="roomId" id="roomId" className="text-center h-6  w-full rounded-md border-1 border-cyan-600  shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm" placeholder="Enter Room ID" />
            </div>
            <div className="flex flex-wrap md:flex-nowrap gap-4">
            <button onClick={joinRoom} className="text-sm md:text-base bg-cyan-500 hover:bg-cyan-900 text-white font-bold  rounded mt-4 w-full">Join Room</button>
            <button onClick={createRoom} className="text-sm md:text-base bg-orange-500 hover:bg-orange-900 text-white font-bold  rounded mt-4 w-full">Create Room</button>
        

            </div>


        </div>

    
    </div>
    );

}

export default JoinCreate;