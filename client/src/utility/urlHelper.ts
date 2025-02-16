import isNode from "detect-node"

const host = isNode ? "http://localhost" : ""

export const testUrl = (strings: TemplateStringsArray, ...values: any[]) => {
  const relativeurl = values.reduce((prev, cur, i) => `${prev}${cur}${strings[i + 1]}`, strings[0])

  return `${host}${relativeurl}`
}
