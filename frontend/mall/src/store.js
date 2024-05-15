import { configureStore } from "@reduxjs/toolkit"; 
import loginSlice from "./slices/loginSlice";

export default configureStore({ // -> 설정에 필요한 정보들을 객체로 전달
    reducer: {
        "loginSlice": loginSlice
    }
})