import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { BrowserRouter} from 'react-router'
import AppRoutes from './config/Routes.jsx'
import { Toaster, toast } from "react-hot-toast";
import { ChatProvider } from './context/ChatContext.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
    <ChatProvider>
      <Toaster position="top-right" />
      <AppRoutes/>
      </ChatProvider>
    </BrowserRouter>
  </StrictMode>,
)
