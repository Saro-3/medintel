import React, { useEffect, useRef } from "react";
import { useState } from "react";
import medicineApi from "../../api/medicineApi";
import "../../css/chatbot.css";

const ChatInput = ({ onSend, loading }) => {
  const [text, setText] = useState("");
  const [ghostText, setGhostText] = useState("");
  const inputRef = useRef(null);

  const handleChange = async (e) => {
    const value = e.target.value;
    setText(value);

    if (value.length >= 2) {
      const results = await medicineApi(value);
      if (results.length > 0 && results[0].startsWith(value)) {
        setGhostText(results[0].slice(value.length));
      } else {
        setGhostText("");
      }
    } else {
      setGhostText("");
    }
  };

  const handleKeyDown = (e) => {
    if (e.key === "Tab" && ghostText) {
      e.preventDefault();
      setText((prev) => prev + ghostText);
      setGhostText("");
    }
    if (e.key === "Enter") {
      e.preventDefault();
      handleSend();
    }
  };

  const handleSend = () => {
    if (!text.trim()) return;

    onSend(text);
    setText("");
    setGhostText("");

    setTimeout(() => {
      inputRef.current?.focus();
    }, 0);
  };

  useEffect(() => {
    if(!loading) {
      inputRef.current?.focus();
    }
  }, [loading]);

  return (
    <div className="chatbot-input">
      <div className="input-wrapper">
        <span className="ghost-text">
          {text}
          <span className="ghost-suggestion">{ghostText}</span>
        </span>

        <input
          ref={inputRef}
          value={text}
          onChange={handleChange}
          onKeyDown={handleKeyDown}
          placeholder="Ask about medicine..."
          disabled={loading}
        />
      </div>
      <button 
      className="send-btn" 
      onClick={handleSend} 
      disabled={loading}
      >
        ➤
      </button>
    </div>
  );
};
export default ChatInput;
