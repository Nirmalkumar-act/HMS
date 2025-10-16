import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  build: {
    outDir: 'dist', // Output folder for production build
  },
  publicDir: 'public', // Folder for static assets
  server: {
    port: 5173, // Optional: development server port
    open: true, // Auto open browser on `npm run dev`
  },
  // ✅ Fix for React Router paths in production (important for Netlify)
  base: './',
})
