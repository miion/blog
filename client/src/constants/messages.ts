import localeKo from "antd/locale/ko_KR"
import localeEn from "antd/locale/en_US"
import "dayjs/locale/ko"
import "dayjs/locale/en"

export const messages: Record<string, Record<string, string>> = {}

export const antdLocale = {
  en: localeEn,
  ko: localeKo,
}
