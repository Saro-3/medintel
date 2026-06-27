import React from "react";
import "../../css/chatbot.css";
import BotAvatar from "../../assets/avatar/BotAvatar"
import UserAvatar from "../../assets/avatar/UserAvatar"

const formatTime = (time) => {
  return new Date(time).toLocaleTimeString([], {
    hour: "2-digit",
    minute: "2-digit",
  });
};

const MessageBubble = ({ sender, text, time }) => {
  return (
    <div className={`message-row ${sender}`}>
      {sender === "bot" && <BotAvatar />}

      <div className="bubble-container">
      <div className={`bubble ${sender}`}>{text}</div>
      <div className="timestamp">{formatTime(time)}</div>
      </div>

      {sender === "user" && <UserAvatar />}
    </div>
  );
};

export default MessageBubble;
