import React, { useState } from "react";
import chatbotApi from "../api/chatbotApi";

const GREETINGS = ["hi", "hello", "hey", "hello there", "hai"];

const THANKS = ["thanks", "thank you", "thanks a lot", "thankyou"];

const GOODBYES = ["bye", "goodbye", "see you", "bye bye"];

const useChatBot = () => {
  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(false);

  const matchIntent = (input, list) => {
    return list.some((word) => input === word);
  };

  const sendMessage = async (text) => {
    if (!text) return;

    const userMessage = text.toLowerCase().trim();

    setMessages((prev) => [
      ...prev,
      { sender: "user", text, time: new Date() },
    ]);

    if (matchIntent(userMessage, GREETINGS)) {
      setLoading(true);

      setTimeout(() => {
        setMessages((prev) => [
          ...prev,
          {
            sender: "bot",
            text: "How are you? What can I help you today?",
            time: new Date(),
          },
        ]);
        setLoading(false);
      }, 1000);
      return;
    }

    /* 🔹 THANK YOU */
    if (matchIntent(userMessage, THANKS)) {
      setLoading(true);

      setTimeout(() => {
        setMessages((prev) => [
          ...prev,
          {
            sender: "bot",
            text: "You're welcome! Let me know if you need anything else.",
            time: new Date(),
          },
        ]);
        setLoading(false);
      }, 1000);

      return;
    }

    /* 🔹 GOODBYE */
    if (matchIntent(userMessage, GOODBYES)) {
      setLoading(true);

      setTimeout(() => {
        setMessages((prev) => [
          ...prev,
          {
            sender: "bot",
            text: "Goodbye! Take care and stay healthy.",
            time: new Date(),
          },
        ]);
        setLoading(false);
      }, 1000);

      return;
    }

    setLoading(true);

    try {
      const reply = await chatbotApi(text);

      setTimeout(() => {
        setMessages((prev) => [
          ...prev,
          { sender: "bot", text: reply, time: new Date() },
        ]);
        setLoading(false);
      }, 2000);
    } catch (error) {
      setTimeout(() => {
        setMessages((prev) => [
          ...prev,
          {
            sender: "bot",
            text: "Something went wrong. Please try again.",
            time: new Date(),
          },
        ]);
        setLoading(false);
      }, 2000);
    }
  };
  return { messages, loading, sendMessage };
};

export default useChatBot;
