import { currentLocale } from "@infra/i18n/locale"
import ko_KR from "@/lang/ko_KR.json"
import { antdLocale, messages } from "@/constants/messages"

export const getCurrentMessages = (): Record<string, string> => {
  return messages[currentLocale()] ?? ko_KR
}

export const getCurrentLocale = () => {
  return antdLocale[currentLocale()]
}
