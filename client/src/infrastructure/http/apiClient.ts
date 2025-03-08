import axios, {
  AxiosError,
  AxiosInstance,
  AxiosRequestConfig,
  AxiosResponse,
  CreateAxiosDefaults,
} from "axios"
import { ZodSchema } from "zod"
import { parse } from "../schema/parse"
import { testUrl } from "@/utility/urlHelper"

export enum RequestMethod {
  GET = "GET",
  POST = "POST",
  PUT = "PUT",
  DELETE = "DELETE",
}

const defaultHeader = {
  "Cache-Control": "no-cache",
  "X-Requested-With": "XMLHttpRequest",
  Pragma: "no-cache",
  Expires: "-1",
  Accept: "application/json, text/plain, */*",
}

export interface RequestSpecification {
  url: string
  method?: RequestMethod
  query?: any
  data?: any
  headers?: any
  containHead?: boolean
}

const client: AxiosInstance = axios.create({
  headers: defaultHeader,
  timeout: 3000,
  withCredentials: true,
} as CreateAxiosDefaults)

const convertApiError = (error: AxiosError): Promise<any> => {
  throw error
}

const requestWith = <T>(parameters: RequestSpecification): Promise<AxiosResponse<T>> => {
  const { url, method = RequestMethod.GET, query = {}, data, headers: customHeaders } = parameters

  const spec: AxiosRequestConfig = {
    url: testUrl`/api${url}`,
    params: query,
    data,
    method,
    headers: {
      ...customHeaders,
    },
  }
  return client.request(spec)
}

const get = <T>(parameters: RequestSpecification, schema?: ZodSchema): Promise<T> =>
  requestWith<T>({ method: RequestMethod.GET, ...parameters })
    .then((res) => res.data)
    .catch(convertApiError)
    .then((data) => parse(data, schema, parameters))

const post = <T>(parameters: RequestSpecification, schema?: ZodSchema): Promise<T> =>
  requestWith<T>({ method: RequestMethod.POST, ...parameters })
    .then((res) => res.data)
    .catch(convertApiError)

const put = <T>(parameters: RequestSpecification, schema?: ZodSchema): Promise<T> =>
  requestWith<T>({ method: RequestMethod.PUT, ...parameters })
    .then((res) => res.data)
    .catch(convertApiError)

const del = <T>(parameters: RequestSpecification, schema?: ZodSchema): Promise<T> =>
  requestWith<T>({ method: RequestMethod.DELETE, ...parameters })
    .then((res) => res.data)
    .catch(convertApiError)

export default {
  get,
  post,
  put,
  del,
}
