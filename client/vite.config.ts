import { defineConfig } from "vite"
import react from "@vitejs/plugin-react"

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react({
      babel: {
        babelrc: true,
      },
    }),
  ],
  resolve: {
    alias: [
      { find: "@lib", replacement: "./lib" },
      { find: "@data", replacement: "./data" },
      { find: "@components", replacement: "./components" },
      { find: "@", replacement: "/src" },
      { find: "@infra", replacement: "/src/infrastructure" },
    ],
  },
  server: {
    port: 4001,
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
      },
      "/ws-stomp": {
        target: "http://localhost:8080",
        ws: true,
        rewriteWsOrigin: true,
      },
    },
  },
  define: { global: "window" },
})
