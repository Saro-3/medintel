import React from "react";
import { useState } from "react";
import "../../css/chatbot.css";
import ChatbotWidget from "../chatbot/ChatbotWidget";

const ChatbotLauncher = () => {
  const [open, setOpen] = useState(false);

  return (
    <div>
      {open && <ChatbotWidget onClose={() => setOpen(false)} />}
      <div className="chatbot-launcher" onClick={() => setOpen(true)}>
        <svg
          width="26"
          height="26"
          viewBox="0 0 24 24"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M12 2C6.48 2 2 6.02 2 11c0 2.35 1.05 4.47 2.77 6.05L4 22l4.29-2.29c1.15.31 2.4.48 3.71.48 5.52 0 10-4.02 10-9s-4.48-9-10-9z"
            fill="white"
          />
        </svg>
      </div>
    </div>
  );
};

export default ChatbotLauncher;
