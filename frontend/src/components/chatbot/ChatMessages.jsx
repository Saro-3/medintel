import React, { useEffect, useRef } from "react";
import MessageBubble from "./MessageBubble";
import "../../css/chatbot.css";
import BotAvatar from "../../assets/avatar/BotAvatar"

const ChatMessages = ({ messages, loading }) => {
  const bottomRef = useRef(null);

  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  return (
    <div className="chatbot-messages">
      {messages.length === 0 && (
        <MessageBubble sender="bot" text="Hello there!" time={new Date()}/>
      )}

      {messages.map((msg, i) => (
        <MessageBubble 
        key={i} 
        sender={msg.sender} 
        text={msg.text}
        time={msg.time} />
      ))}
      {loading && (
        <div className="message-row bot">
          <BotAvatar />
          <div className="typing">Bot is typing</div>
        </div>
      )}
      <div ref={bottomRef}/>
    </div>
  );
};

export default ChatMessages;
