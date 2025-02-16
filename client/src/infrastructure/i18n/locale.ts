import LocalStorage from "@infra/store/LocalStorage"

const DEFAULT_LOCALE = "ko"

export type SUPPORTED_LOCALE = "ko" | "en"

export const currentLocale = (): SUPPORTED_LOCALE => {
  const locale = LocalStorage.getItem("locale") as SUPPORTED_LOCALE
  if (!locale) {
    LocalStorage.setItem("locale", DEFAULT_LOCALE)
    return DEFAULT_LOCALE
  }
  return locale
}
