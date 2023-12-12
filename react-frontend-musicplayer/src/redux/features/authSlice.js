import { createSlice } from '@reduxjs/toolkit';

const authSlice = createSlice({
  name: 'auth',
  initialState: { isAuthenticated: false, idToken: null },
  reducers: {
    login(state, action) {
      state.isAuthenticated = true;
      state.idToken = action.payload;
    },
    logout(state) {
      state.isAuthenticated = false;
      state.idToken = null;
    },
  },
});

export const { login, logout } = authSlice.actions;

export default authSlice.reducer;