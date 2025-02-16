export {}

declare global {
  interface Window {
    toggleDevtools: () => void
    startMSW: () => void
    stopMSW: () => void
  }
}
