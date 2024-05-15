import { createSlice } from "@reduxjs/toolkit";

const initState = {
    email: ''
}

const loginSlice = createSlice({
    name: 'LoginSlice',
    initialState: initState,
    reducers: {
        login: (state, action) => {
            console.log("Login.......")
        },
        logout: (state, action) => {
            console.log("Logout......")
        }
    }
})

export const {login, logout} = loginSlice.actions

export default loginSlice.reducer