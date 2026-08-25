import React, { useEffect,useRef, useState } from "react";
import DarkModeToggleSwitch from "./DarkModeToggleSwitch";
import { IoIosAttach } from "react-icons/io";
import { IoSend } from "react-icons/io5";
import userChatContext from "../context/ChatContext";
import { useNavigate } from "react-router";
import { baseURL } from "../config/AxiosHelper";
import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";
import toast from "react-hot-toast";
import { formatDistanceToNow } from "date-fns";

const ChatPage = () => {

  const {userName,setUserName,connected,setConnected,roomId,setRoomId}= userChatContext();
  const [input,setInput]=useState("")
  const clientRef = useRef(null);
  const [messages,setMessages]=useState([]);
  const navigate= useNavigate();
  const messagesEndRef = useRef(null);

  useEffect(()=>{

    setMessages(messages)
    messagesEndRef.current?.scrollIntoView({
        behavior: "smooth"
    });

  },[messages])

  const sendMessage=()=>{
    if(input.trim() && connected)
    {

        clientRef.current.publish({
        destination: `/app/sendMessage/${roomId}`,
        body: JSON.stringify({
            roomId: roomId,
            sender: userName,
            content: input
        })       
        
    });
     console.log("Message Sent")

    }
    setInput("")
  }

  useEffect(()=>{
     if (!connected) {
        navigate("/");
    }
  },[userName,roomId,connected])





useEffect(()=>{
 const client = new Client({
        webSocketFactory: () => new SockJS(`${baseURL}/chat`),

        onConnect: () => {
            console.log("WebSocket connected");
            client.subscribe(`/topic/room/${roomId}`, (message) => {

              const receivedMessage = JSON.parse(message.body);

                setMessages(prev => [
                    ...prev,
                    receivedMessage
                ]);
    });
        },

        onStompError: (frame) => {
            console.error("STOMP error:", frame);
        }
    });
    clientRef.current=client;
    client.activate();

    return () => {
        client.deactivate();
        clientRef.current=null;
    };
},[roomId])


const logoutFromRoom=()=>{
   navigate("/")
   toast.success("User Logged Out SuccessFully")
}




  return (
    <div className="flex flex-col justify-between min-h-screen pb-20">
      <div className=" bg-white text-black flex justify-between dark:bg-gray-600 fixed top-0 left-0 w-full">
        <DarkModeToggleSwitch className="bg-transparent text-yellow p-2" />
        <div className="ml-4">
        <h3 className="mt-2 font-serif font-light text-2xl border-l-amber-100 bg-amber-200 rounded-2xl p-2">
            Room ID: {roomId}
        </h3>
    </div>
        <div className="">
          <button  onClick={logoutFromRoom} className="text-sm font-medium bg-red-300 rounded-2xl  w-20 p-2 m-3">
            Logout
          </button>
        </div>
      </div>
      <main className="w-2/3 mx-auto dark:bg-slate-800 border-2 h-screen border-amber-600 overflow-auto py-20" >
        <div className="chat-page flex flex-col gap-2">
          
          {

              messages.map((message,index)=>(
                <div key={index} className={`flex ${
        message.sender === `${userName}` ? "justify-end" : "justify-start"
      } my-1`}>
                  <div className={`flex flex-row gap-2 ${message.sender===`${userName}`?'bg-cyan-400 dark:bg-blue-500':'bg-emerald-400 dark:bg-green-500 '} p-2 rounded-2xl text-sm`}>
                    <img src={`https://ui-avatars.com/api/?name=${message.sender}`} className="size-8 rounded-3xl"></img>
                    <div className="flex flex-col">
                    <p className="text-xs">
                      {message.sender} ·{" "}
                          {formatDistanceToNow(new Date(message.timeStamp), {
                              addSuffix: true
                          })}</p>
                    <p>{message.content}</p>
                     <div ref={messagesEndRef} />
                    </div>
                  </div>
                </div>

              ))
          }
  
          
        </div>

      </main>
     


  


    <div className="flex justify-center fixed bottom-0 left-0 w-full">
    <div className="pl-10 flex flex-wrap gap-2 md:flex-nowrap justify-center dark:bg-gray-600  ml-10 mr-10">

        <input value={input} type="text" onChange={(e)=>{
          setInput(e.target.value)
        }} 
        placeholder="Type Your Message" className=" flex w-3xl rounded-3xl text-center"></input>
        <button className="text-sm font-medium bg-cyan-400 rounded-2xl p-2 w-20  flex justify-center items-center"><IoIosAttach/></button>
        <button onClick={sendMessage} className="text-sm font-medium bg-green-400 rounded-2xl p-2 w-20 flex  justify-center items-center"><IoSend/></button>
    
    </div>
    </div>


    </div>
  );
};

export default ChatPage;
