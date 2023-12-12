import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react';

export const shazamCoreApi = createApi({
  
  reducerPath: "shazamCoreApi",
  baseQuery: fetchBaseQuery({
    baseUrl: "http://localhost:9000/api/v1",
    prepareHeaders: (headers) => {
      const token = window.sessionStorage.getItem("id_token");
      headers.append("Content-Type", "text/plain");
      headers.append("Authorization", `Bearer ${token}`);
      return headers;
    },
}),

  endpoints: (builder) => ({
    getTopCharts: builder.query({
      query: () => '/top-charts',
    }),
    getSongsByGenre: builder.query({
      query: (genre) => `/top-songs-by-genre=${genre}`,
    }),
    getSongsByCountry: builder.query({
      query: (countryCode) => `/around-you/${countryCode}`,
    }),
    getSongsBySearch: builder.query({
      query: (searchTerm) => `/search/${searchTerm}`,
    }),
    getArtistDetails: builder.query({
      query: (artistId) => `/artists/${artistId}`,
    }),
    getSongDetails: builder.query({
      query: (songId) => `/songs/${songId}`,
    }),
    getSongRelated: builder.query({
      query: (songId) => `/songs/related/${songId}`,
    }),
  }),
  
});

export const {
    useGetTopChartsQuery,
    useGetSongsByGenreQuery,
    useGetSongsByCountryQuery,
    useGetSongsBySearchQuery,
    useGetArtistDetailsQuery,
    useGetSongDetailsQuery,
    useGetSongRelatedQuery,
} = shazamCoreApi;