import React from "react";
import { IoChatbubblesOutline } from "react-icons/io5";
import DarkModeToggleSwitch from "./DarkModeToggleSwitch";


const JoinCreate = () => {

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
            <input type="text" name="roomId" id="roomId" className="text-center h-6  w-full rounded-md border-1 border-cyan-600  shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm" placeholder="Enter Your Name" />
            </div>
            <div className="flex-col flex-wrap md:flex-nowrap gap-4">
            <label htmlFor="roomId" className="text-sm sm:text-sm md:text-sm" >Room ID</label>
            <input type="text" name="roomId" id="roomId" className="text-center h-6  w-full rounded-md border-1 border-cyan-600  shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm" placeholder="Enter Room ID" />
            </div>
            <div className="flex flex-wrap md:flex-nowrap gap-4">
            <button className="text-sm md:text-base bg-cyan-500 hover:bg-cyan-900 text-white font-bold  rounded mt-4 w-full">Join Room</button>
            <button className="text-sm md:text-base bg-orange-500 hover:bg-orange-900 text-white font-bold  rounded mt-4 w-full">Create Room</button>
        

            </div>


        </div>

    
    </div>
    );

}

export default JoinCreate;