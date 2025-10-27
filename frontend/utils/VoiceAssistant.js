// src/utils/VoiceAssistant.js
export class VoiceAssistant {
  constructor(onResultCallback) {
    const SpeechRecognition =
      window.SpeechRecognition || window.webkitSpeechRecognition;
    if (!SpeechRecognition) {
      alert("Speech recognition not supported in your browser.");
      return;
    }

    this.recognition = new SpeechRecognition();
    this.recognition.lang = "en-IN";
    this.recognition.continuous = false;
    this.recognition.interimResults = false;
    this.recognition.onresult = (event) => {
      const transcript = event.results[0][0].transcript.trim();
      onResultCallback(transcript);
    };
  }

  startListening() {
    this.recognition.start();
  }

  stopListening() {
    this.recognition.stop();
  }

  static speak(text) {
    const synth = window.speechSynthesis;
    const utter = new SpeechSynthesisUtterance(text);
    utter.lang = "en-IN";
    utter.pitch = 1;
    utter.rate = 1;
    synth.speak(utter);
  }
}
