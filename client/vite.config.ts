import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: [
      { find: "@lib", replacement: "./lib" },
      { find: "@data", replacement: "./data"},
      { find: "@components", replacement: "./components" },
      { find: "@", replacement: "/src" },
      { find: "@infra", replacement: "/src/infrastructure" },
    ],
  },
})
