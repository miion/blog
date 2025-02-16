import { SUPPORTED_LOCALE } from "@/infrastructure/i18n/locale"
import { Dropdown, MenuProps } from "antd"
import { ReactElement, useCallback } from "react"
import { FormattedMessage } from "react-intl"
import styled from "styled-components"
import { useLocalStorage } from "usehooks-ts"
import { KR, US } from "country-flag-icons/react/1x1"

const Wrapper = styled.a`
  align-items: center;
  justify-content: center;
  display: flex;
`

const iconStyles = {
  width: "30px",
  borderRadius: "50%",
  cursor: "pointer",
}

const iconMap: Record<string, ReactElement> = {
  ko: <KR style={iconStyles} />,
  en: <US style={iconStyles} />,
}

const CountrySelect = () => {
  const [locale, setLocale] = useLocalStorage<SUPPORTED_LOCALE>("locale", "ko")

  const handleChange = useCallback(
    (locale: SUPPORTED_LOCALE) => {
      setLocale(locale)
      window.location.reload()
    },
    [setLocale]
  )

  const items: MenuProps["items"] = [
    {
      key: "ko",
      label: (
        <a onClick={() => handleChange("ko")}>
          <FormattedMessage defaultMessage="한국어" />
        </a>
      ),
      icon: <KR style={iconStyles} />,
    },
    {
      key: "en",
      label: (
        <a onClick={() => handleChange("ko")}>
          <FormattedMessage defaultMessage="영어" />
        </a>
      ),
      icon: <US style={iconStyles} />,
    },
  ]

  return (
    <Dropdown menu={{ items }} trigger={["click"]}>
      <Wrapper>{iconMap[locale]}</Wrapper>
    </Dropdown>
  )
}

CountrySelect.displayName = "CountrySelect"
export default CountrySelect
