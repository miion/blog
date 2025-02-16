import { z } from "zod"
import { RequestSpecification } from "../http/apiClient"

export const parse = <T extends z.ZodTypeAny>(
  data: unknown,
  schema?: T,
  parameters?: RequestSpecification
): z.infer<T> => {
  if (!schema) {
    return data
  }
  const result = schema.safeParse(data)
  if (result.success) {
    return result.data
  }

  const error = result.error
  const url = parameters?.url ?? "unknown"

  // Sentry.captureException(new Error(`url: ${url}` + error.message))
  return data
}
