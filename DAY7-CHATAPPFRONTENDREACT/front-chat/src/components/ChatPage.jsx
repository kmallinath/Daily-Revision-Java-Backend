import React from "react";
import DarkModeToggleSwitch from "./DarkModeToggleSwitch";
import { IoIosAttach } from "react-icons/io";
import { IoSend } from "react-icons/io5";


const ChatPage = () => {
  return (
    <div className="flex flex-col justify-between min-h-screen pb-20">
      <div className=" bg-white text-black flex justify-between dark:bg-gray-600 fixed top-0 left-0 w-full">
        <DarkModeToggleSwitch className="bg-transparent text-yellow p-2" />
        <div className="">
          <button className="text-sm font-medium bg-red-300 rounded-2xl  w-20 p-2 m-3">
            Logout
          </button>
        </div>
      </div>
      <div className="chat-page mt-30">CHAT PAGE</div>


  


    <div className="flex justify-center fixed bottom-0 left-0 w-full">
    <div className="pl-10 flex flex-wrap gap-2 md:flex-nowrap justify-center dark:bg-gray-600  ml-10 mr-10">

        <input type="text"  placeholder="Type Your Message" className=" flex w-3xl rounded-3xl text-center"></input>
        <button className="text-sm font-medium bg-cyan-400 rounded-2xl p-2 w-20  flex justify-center items-center"><IoIosAttach/></button>
        <button className="text-sm font-medium bg-green-400 rounded-2xl p-2 w-20 flex  justify-center items-center"><IoSend/></button>
    
    </div>
    </div>


    </div>
  );
};

export default ChatPage;
