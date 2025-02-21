import js from "@eslint/js"
import globals from "globals"
import reactHooks from "eslint-plugin-react-hooks"
import reactRefresh from "eslint-plugin-react-refresh"
import tseslint from "typescript-eslint"
import tanstack from "@tanstack/eslint-plugin-query"
import formatjs from "eslint-plugin-formatjs"

export default tseslint.config(
  { ignores: ["dist"] },
  {
    extends: [js.configs.recommended, ...tseslint.configs.recommended, ...tanstack.recommended],
    files: ["**/*.{js,jsx,ts,tsx}"],
    languageOptions: {
      ecmaVersion: 2020,
      globals: globals.browser,
    },
    plugins: {
      "react-hooks": reactHooks,
      "react-refresh": reactRefresh,
      tanstack,
      formatjs,
    },
    rules: {
      // common
      "no-alert": "error",
      "no-debugger": "error",

      // react
      ...reactHooks.configs.recommended.rules,
      "react-refresh/only-export-components": ["warn", { allowConstantExport: true }],

      // formatjs
      "formatjs/no-offset": "error",
      "formatjs/enforce-default-message": ["error", "literal"],
      "formatjs/no-emoji": "error",
      "formatjs/no-literal-string-in-jsx": "error",
      "formatjs/no-multiple-whitespaces": "error",
    },
  }
)
