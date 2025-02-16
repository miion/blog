export const associateBy = <V>(arr: V[], indexer: (t1: V) => number | string) => {
  const res = {} as Record<number | string, V>
  arr.forEach((item) => {
    res[indexer(item)] = item
  })
  return res
}

export const groupBy = <V>(arr: V[], indexer: (t1: V) => number | string) => {
  const res = {} as Record<number | string, V[]>
  arr.forEach((item) => {
    const index = indexer(item)
    const group: V[] = res[index] || []
    group.push(item)
    res[index] = group
  })
  return res
}

export const sumBy = <V>(arr: V[], indexer: (t1: V) => number) => {
  let res = 0
  arr.forEach((item: V) => {
    res += indexer(item)
  })
  return res
}
