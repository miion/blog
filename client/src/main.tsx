import App from "@/App"
import { getCurrentMessages } from "@infra/i18n/i18n"
import { currentLocale } from "@infra/i18n/locale"
import "@infra/msw/config"
import { StrictMode } from "react"
import { createRoot } from "react-dom/client"
import { IntlProvider } from "react-intl"
import GlobalStyle from "./assets/styles/global.style"

createRoot(document.getElementById("root")!).render(
  <>
    <GlobalStyle />
    {/* <StrictMode> */}
    <IntlProvider
      locale={currentLocale()}
      defaultLocale={currentLocale()}
      messages={getCurrentMessages()}>
      <App />
    </IntlProvider>
    {/* </StrictMode> */}
  </>
)
