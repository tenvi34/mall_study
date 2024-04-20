import axios from "axios";
import { API_SERVER_HOST } from "./todoApi"

const host = `${API_SERVER_HOST}/api/products`

// 상품 추가
export const postAdd = async (product) => {

    const header = { headers: { "Content-Type": "multipart/form-data" } }

    const res = await axios.post(`${host}/`, product, header)

    return res.data
}

// 목록 출력
export const getList = async (pageParam) => {

    const { page, size } = pageParam

    const res = await axios.get(`${host}/list`, { params: { page: page, size: size } })

    return res.data
}

// 특정 상품 조회
export const getOne = async (pno) => {

    const res = await axios.get(`${host}/${pno}`)

    return res.data
}

// 수정
export const putOne = async (pno, product) => {

    const header = { headers: { "Content-Type": "multipart/form-data" } }

    const res = await axios.put(`${host}/${pno}`, product, header)

    return res.data
}

// 삭제
export const deleteOne = async (pno) => {

    const res = await axios.delete(`${host}/${pno}`)

    return res.data
}