import React from "react";
import useChatBot from "../../hooks/useChatBot";
import ChatMessages from "./ChatMessages";
import ChatInput from "./ChatInput";
import "../../css/chatbot.css";

const ChatbotWidget = ({ onClose }) => {
  const { messages, sendMessage, loading } = useChatBot();
  return (
    <div className="chatbot-widget">
      <div className="chatbot-header">
        <span>MedIntel Bot</span>
        <button onClick={onClose}>✖</button>
      </div>
      <ChatMessages messages={messages} loading={loading}/>

      <ChatInput onSend={sendMessage} loading={loading} />
    </div>
  );
};

export default ChatbotWidget;
