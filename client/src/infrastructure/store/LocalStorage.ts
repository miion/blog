export type LOCAL_STORAGE_KEY = "locale" | "theme"

export default {
  getItem: (key: LOCAL_STORAGE_KEY, defaultValue?: string): string => {
    const item = window.localStorage.getItem(key)
    return item ? JSON.parse(item) : (defaultValue ?? "")
  },
  setItem: (key: LOCAL_STORAGE_KEY, value: string) => {
    window.localStorage.setItem(key, JSON.stringify(value))
  },
}
