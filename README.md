### Secure Spring Boot Resource Server with React Frontend

### Overview

---

This project demonstrates a secure architecture for building a web application using Spring Boot, OAuth 2.0 Authorization Server, a Redis instance on Docker for session management, Redux Toolkit for state management, and a React frontend. The application follows best practices for user authentication by implementing the Authorization Code Flow with PKCE (Proof Key for Code Exchange).

### Architecture

---
![Architecture](snapshots/spring-resource-server-flow.png?raw=true "Flow Diagram")

![Architecture](snapshots/spring-auth-server-flow.png?raw=true "Auth Flow Diagram")

### Features

## Spring Boot Resource Server
- Serves protected resources.
- Validates access tokens issued by the Authorization Server.
- Defines RESTful endpoints for secure data access.
- Built with Maven for dependency management and build automation.

## Spring Authorization Server
- Manages user authentication with Authorization Code Flow and PKCE.
- Issues OAuth 2.0 access tokens for secure communication.
- Configures clients, including the React frontend, for token issuance.
- Utilizes Redis on Docker for efficient and scalable session management.
- Built with Gradle for dependency management and build automation.

## React Frontend
- Implements a responsive user interface using React.
- Uses Authorization Code Flow with PKCE for secure user authentication.
- Consumes protected resources from the Spring Boot Resource Server.
- Utilizes Redux Toolkit for efficient state management.
- Makes endpoint requests using Redux Toolkit's capabilities.

## Security and State Management Highlights
- Authorization Code Flow with PKCE: Enhances security for user authentication.
- Token Validation: Ensures access tokens are valid before serving protected resources.
- Client Registration: Controls which clients are authorized to request access tokens.
- Redis for Session Management: Efficient and scalable session management for the Authorization Server.
- Redux Toolkit: Streamlines state management in the React frontend with efficient tools and patterns.

### Database Design
---
![Database Design](snapshots/AuthServer-database.png?raw=true "Database Flow Diagram")

### UI Snapshots

---

<details><summary><b>Snapshots</b></summary>

![Home Page](snapshots/home-page.png?raw=true "Home Page")
![Discover](snapshots/discover-snapshot.png?raw=true "Discover")
![Around you](snapshots/around-you-snapshot.png?raw=true "Around you")
![Top Artists](snapshots/top-artists-snapshot.png?raw=true "Top Artists")
![Top Charts](snapshots/top-charts-snapshot.png?raw=true "Top Charts")
![Artist Details](snapshots/artist-details.png?raw=true "Artist Details")
![Song Details](snapshots/song-details.png?raw=true "Song Details")
![Search results](snapshots/search-results.png?raw=true "Search results")
![Music player](snapshots/music-player.png?raw=true "Music player")
</details>

### REST API Specification

---

All protected endpoints return only data relevant to the currently logged in user.
They require user ID, JWT access token from the request header sent by the client.

<details><summary><b>Endpoint Details</b></summary>


| Endpoint                                      | HTTP Method | Access    | Description                         | Request Body                                                                                    |
|-----------------------------------------------|-------------|-----------|-------------------------------------|-------------------------------------------------------------------------------------------------|
| **/api/v1//artists/:artistId**                | GET         | Protected | Read artist by ID                   |                                                                                                 |
| **/api/v1/songs/:songId**                     | GET         | Protected | Read song by ID                     |                                                                                                 |
| **/api/v1/songs/related/:songId**             | GET         | Protected | Read related songs by ID            |                                                                                                 |
| **/api//v1/songs/around-you/:countryCode**    | GET         | Protected | Read songs around you               |                                                                                                 |
| **/api/v1/search/:searchTerm**                | GET         | Protected | Search songs or artists by name     |                                                                                                 |
| **/api//v1/top-songs-by-genre={genre}**       | GET         | Protected | Top songs by genre                  |                                                                                                 |
| **/api//v1//top-charts**                      | GET         | Protected | Top charts                          |                                                                                                 |
| **/register**                                 | POST        | Public    | Register user                       |                                                                                                 |
| **/login**                                    | POST        | Public    | Login as user                       |                                                                                                 |
| **/logout**                                   | POST        | Public    | Logout                              |                                                                                                 |


</details>

### JSON Responses

---

<details><summary><b>Search</b></summary>

```json
{
  "tracks": {
    "hits": [
      {
        "track": {
          "layout": "5",
          "type": "MUSIC",
          "key": "10314010",
          "title": "Enter Sandman",
          "subtitle": "Metallica",
          "share": {
            "subject": "Enter Sandman - Metallica",
            "text": "Enter Sandman by Metallica",
            "href": "https://www.shazam.com/track/10314010/enter-sandman",
            "image": "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/18/93/db/1893db5c-ddd1-b95c-3112-b9b83bcceab0/0093624986553.jpg/400x400cc.jpg",
            "twitter": "I used @Shazam to discover Enter Sandman by Metallica.",
            "html": "https://www.shazam.com/snippets/email-share/10314010?lang=en&country=US",
            "avatar": "https://is1-ssl.mzstatic.com/image/thumb/AMCArtistImages112/v4/7c/ec/2d/7cec2d74-d50a-445e-eea6-f6097a01cea7/00e0f5e1-2dd6-4f71-bbdf-d2cbdd7560eb_ami-identity-7650ac390e73210afeaf26aae0ec7e10-2022-11-28T21-57-07.638Z_cropped.png/800x800cc.jpg",
            "snapchat": "https://www.shazam.com/partner/sc/track/10314010"
          },
          "images": {
            "background": "https://is1-ssl.mzstatic.com/image/thumb/AMCArtistImages112/v4/7c/ec/2d/7cec2d74-d50a-445e-eea6-f6097a01cea7/00e0f5e1-2dd6-4f71-bbdf-d2cbdd7560eb_ami-identity-7650ac390e73210afeaf26aae0ec7e10-2022-11-28T21-57-07.638Z_cropped.png/800x800cc.jpg",
            "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/18/93/db/1893db5c-ddd1-b95c-3112-b9b83bcceab0/0093624986553.jpg/400x400cc.jpg",
            "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music125/v4/18/93/db/1893db5c-ddd1-b95c-3112-b9b83bcceab0/0093624986553.jpg/400x400cc.jpg",
            "joecolor": "b:000000p:f2f2f2s:e5e5e5t:c1c1c1q:b7b7b7"
          },
  "artists": {
    "hits": [
      {
        "artist": {
          "avatar": "https://is1-ssl.mzstatic.com/image/thumb/AMCArtistImages112/v4/7c/ec/2d/7cec2d74-d50a-445e-eea6-f6097a01cea7/00e0f5e1-2dd6-4f71-bbdf-d2cbdd7560eb_ami-identity-7650ac390e73210afeaf26aae0ec7e10-2022-11-28T21-57-07.638Z_cropped.png/800x800bb.jpg",
          "name": "Metallica",
          "verified": false,
          "weburl": "https://music.apple.com/us/artist/metallica/3996865",
          "adamid": "3996865"
        }
      }
    ]
  }
}
```

</details>

<details><summary><b>Artist</b></summary>
```json
{
  "data": [
    {
      "id": "136975",
      "type": "artists",
      "href": "/v1/catalog/us/artists/136975",
      "attributes": {
        "bornOrFormed": "1960",
        "genreNames": [
          "Rock"
        ],
        "editorialArtwork": {
          "originalFlowcaseBrick": {
            "width": 3200,
            "url": "https://is1-ssl.mzstatic.com/image/thumb/Features5/v4/f2/bd/9b/f2bd9ba5-6096-59a5-4fd4-c44606ae7c4d/mza_5393299497892513789.png/440x440bb.jpg",
            "height": 600,
            "textColor3": "cbcbcb",
            "textColor2": "ffffff",
            "textColor4": "cbcbcb",
            "textColor1": "ffffff",
            "bgColor": "000000",
            "hasP3": false
          }
        }
      }
    ]
  }
```

</details>

<details><summary><b>Song Details</b></summary>
```json
{
  "layout": "5",
  "type": "MUSIC",
  "key": "554591360",
  "title": "Wellerman (Sea Shanty)",
  "subtitle": "Nathan Evans",
  "images": {
    "background": "https://is1-ssl.mzstatic.com/image/thumb/Features114/v4/e8/5b/23/e85b2365-cbe4-72fb-1d5f-fb615b270acf/pr_source.png/800x800cc.jpg",
    "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/1a/4b/32/1a4b3200-9ff3-5788-7829-e69aaa9a357d/22UMGIM92872.rgb.jpg/400x400cc.jpg",
    "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/1a/4b/32/1a4b3200-9ff3-5788-7829-e69aaa9a357d/22UMGIM92872.rgb.jpg/400x400cc.jpg",
    "joecolor": "b:100a0ap:d3b8b7s:66aed8t:ac9594q:558daf"
  },
  "share": {
    "subject": "Wellerman (Sea Shanty) - Nathan Evans",
    "text": "Wellerman (Sea Shanty) by Nathan Evans",
    "href": "https://www.shazam.com/track/554591360/wellerman-sea-shanty",
    "image": "https://is1-ssl.mzstatic.com/image/thumb/Music112/v4/1a/4b/32/1a4b3200-9ff3-5788-7829-e69aaa9a357d/22UMGIM92872.rgb.jpg/400x400cc.jpg",
    "twitter": "I used @Shazam to discover Wellerman (Sea Shanty) by Nathan Evans.",
    "html": "https://www.shazam.com/snippets/email-share/554591360?lang=en&country=GB",
    "avatar": "https://is1-ssl.mzstatic.com/image/thumb/Features114/v4/e8/5b/23/e85b2365-cbe4-72fb-1d5f-fb615b270acf/pr_source.png/800x800cc.jpg",
    "snapchat": "https://www.shazam.com/partner/sc/track/554591360"
  }
}
```

</details>

<details><summary><b>Song Related</b></summary>
```json
[
  {
    "layout": "5",
    "type": "MUSIC",
    "key": "560657951",
    "title": "Sea Shanty Medley",
    "subtitle": "Home Free",
    "share": {
      "subject": "Sea Shanty Medley - Home Free",
      "text": "Sea Shanty Medley by Home Free",
      "href": "https://www.shazam.com/track/560657951/sea-shanty-medley",
      "image": "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/2c/6a/89/2c6a89b1-2a9b-122f-2b32-fe2027bc0e0b/196006233419.jpg/400x400cc.jpg",
      "twitter": "I used @Shazam to discover Sea Shanty Medley by Home Free.",
      "html": "https://www.shazam.com/snippets/email-share/560657951?lang=en&country=GB",
      "avatar": "https://is1-ssl.mzstatic.com/image/thumb/Features125/v4/1a/30/6e/1a306ec7-9d09-b32b-e4bf-d7d2156577f7/pr_source.png/800x800cc.jpg",
      "snapchat": "https://www.shazam.com/partner/sc/track/560657951"
    },
    "images": {
      "background": "https://is1-ssl.mzstatic.com/image/thumb/Features125/v4/1a/30/6e/1a306ec7-9d09-b32b-e4bf-d7d2156577f7/pr_source.png/800x800cc.jpg",
      "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/2c/6a/89/2c6a89b1-2a9b-122f-2b32-fe2027bc0e0b/196006233419.jpg/400x400cc.jpg",
      "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music124/v4/2c/6a/89/2c6a89b1-2a9b-122f-2b32-fe2027bc0e0b/196006233419.jpg/400x400cc.jpg",
      "joecolor": "b:16161ep:fbecb2s:ecd51ct:cdc194q:c1af1c"
    }
  }
]
```

</details>

<details><summary><b>Songs Around you</b></summary>
```json
[
  {
    "layout": "5",
    "type": "MUSIC",
    "key": "684440473",
    "title": "Allo Oui",
    "subtitle": "Cheb Hichem TGV",
    "share": {
      "subject": "Allo Oui - Cheb Hichem TGV",
      "text": "Allo Oui by Cheb Hichem TGV",
      "href": "https://www.shazam.com/track/684440473/allo-oui",
      "image": "https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/76/30/89/76308950-5d0b-dc40-42a8-a556866ff22a/cover.jpg/400x400cc.jpg",
      "twitter": "I used @Shazam to discover Allo Oui by Cheb Hichem TGV.",
      "html": "https://www.shazam.com/snippets/email-share/684440473?lang=en&country=GB",
      "snapchat": "https://www.shazam.com/partner/sc/track/684440473"
    },
    "images": {
      "background": "https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/76/30/89/76308950-5d0b-dc40-42a8-a556866ff22a/cover.jpg/400x400cc.jpg",
      "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/76/30/89/76308950-5d0b-dc40-42a8-a556866ff22a/cover.jpg/400x400cc.jpg",
      "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music126/v4/76/30/89/76308950-5d0b-dc40-42a8-a556866ff22a/cover.jpg/400x400cc.jpg",
      "joecolor": "b:0e0e0cp:d0cec7s:b2c2c3t:a9a8a2q:919e9e"
    },
    "hub": {
      "type": "APPLEMUSIC",
      "image": "https://images.shazam.com/static/icons/hub/web/v5/applemusic.png",
      "actions": [
        {
          "name": "apple",
          "type": "applemusicplay",
          "id": "1720273033"
        },
        {
          "name": "apple",
          "type": "uri",
          "uri": "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview126/v4/69/6a/75/696a758e-d80c-dc5e-f724-4dc098724f6c/mzaf_6748436213106582689.plus.aac.ep.m4a"
        }
      ]
```

</details>

<details><summary><b>Top Charts</b></summary>
```json
[
  {
    "layout": "5",
    "type": "MUSIC",
    "key": "544842905",
    "title": "Пыяла",
    "subtitle": "АИГЕЛ",
    "share": {
      "subject": "Пыяла - АИГЕЛ",
      "text": "Пыяла by АИГЕЛ",
      "href": "https://www.shazam.com/track/544842905/%D0%BF%D1%8B%D1%8F%D0%BB%D0%B0",
      "image": "https://is1-ssl.mzstatic.com/image/thumb/Music114/v4/c8/67/3e/c8673ef0-fb83-2ba3-1d5f-dd782f672f92/cover.jpg/400x400cc.jpg",
      "twitter": "I used @Shazam to discover Пыяла by АИГЕЛ.",
      "html": "https://www.shazam.com/snippets/email-share/544842905?lang=en&country=GB",
      "avatar": "https://is1-ssl.mzstatic.com/image/thumb/Features114/v4/95/1a/38/951a381e-f740-b978-8858-16413b6f2b65/mzl.erbtullm.jpg/800x800cc.jpg",
      "snapchat": "https://www.shazam.com/partner/sc/track/544842905"
    },
    "images": {
      "background": "https://is1-ssl.mzstatic.com/image/thumb/Features114/v4/95/1a/38/951a381e-f740-b978-8858-16413b6f2b65/mzl.erbtullm.jpg/800x800cc.jpg",
      "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music114/v4/c8/67/3e/c8673ef0-fb83-2ba3-1d5f-dd782f672f92/cover.jpg/400x400cc.jpg",
      "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music114/v4/c8/67/3e/c8673ef0-fb83-2ba3-1d5f-dd782f672f92/cover.jpg/400x400cc.jpg",
      "joecolor": "b:000b15p:f4ffffs:d2d5fft:c3ced0q:a7acd0"
    },
    "hub": {
      "type": "APPLEMUSIC",
      "image": "https://images.shazam.com/static/icons/hub/web/v5/applemusic.png",
      "actions": [
        {
          "name": "apple",
          "type": "applemusicplay",
          "id": "1539712121"
        },
        {
          "name": "apple",
          "type": "uri",
          "uri": "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview125/v4/c0/01/18/c0011847-e7d5-e44a-c9d2-ed20e4897311/mzaf_13815513855997291591.plus.aac.ep.m4a"
        }
      ],
      "options": [
        {
          "caption": "OPEN",
          "actions": [
            {
              "name": "hub:applemusic:deeplink",
              "type": "applemusicopen",
              "uri": "https://music.apple.com/gb/album/%D0%BF%D1%8B%D1%8F%D0%BB%D0%B0/1539712120?i=1539712121&mttnagencyid=s2n&mttnsiteid=125115&mttn3pid=Apple-Shazam&mttnsub1=Shazam_web&mttnsub2=5348615A-616D-3235-3830-44754D6D5973&itscg=30201&app=music&itsct=Shazam_web"
            },
            {
              "name": "hub:applemusic:deeplink",
              "type": "uri",
              "uri": "https://music.apple.com/gb/album/%D0%BF%D1%8B%D1%8F%D0%BB%D0%B0/1539712120?i=1539712121&mttnagencyid=s2n&mttnsiteid=125115&mttn3pid=Apple-Shazam&mttnsub1=Shazam_web&mttnsub2=5348615A-616D-3235-3830-44754D6D5973&itscg=30201&app=music&itsct=Shazam_web"
            }
          ],
          "beacondata": {
            "type": "open",
            "providername": "applemusic"
          },
          "image": "https://images.shazam.com/static/icons/hub/web/v5/overflow-open-option.png",
          "type": "open",
          "listcaption": "Open in Apple Music",
          "overflowimage": "https://images.shazam.com/static/icons/hub/web/v5/applemusic-overflow.png",
          "colouroverflowimage": false,
          "providername": "applemusic"
        }
      ],
      "explicit": false,
      "displayname": "APPLE MUSIC"
    },
    "artists": [
      {
        "alias": "%D0%B0%D0%B8%D0%B3%D0%B5%D0%BB",
        "id": "42",
        "adamid": "1222911062"
      }
    ],
    "url": "https://www.shazam.com/track/544842905/%D0%BF%D1%8B%D1%8F%D0%BB%D0%B0",
    "highlightsurls": {},
    "properties": {}
  },
  {
    "layout": "5",
    "type": "MUSIC",
    "key": "594265720",
    "title": "THE REV3NGE",
    "subtitle": "Joey Bada$$",
    "share": {
      "subject": "THE REV3NGE - Joey Bada$$",
      "text": "THE REV3NGE by Joey Bada$$",
      "href": "https://www.shazam.com/track/594265720/the-rev3nge",
      "image": "https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/23/95/9b/23959b6c-7cab-d838-4e62-5700dd11ef6a/886449666904.jpg/400x400cc.jpg",
      "twitter": "I used @Shazam to discover THE REV3NGE by Joey Bada$$.",
      "html": "https://www.shazam.com/snippets/email-share/594265720?lang=en&country=GB",
      "avatar": "https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/e8/47/e4/e847e492-2c31-bea2-2753-d725e4024bbc/pr_source.png/800x800cc.jpg",
      "snapchat": "https://www.shazam.com/partner/sc/track/594265720"
    },
    "images": {
      "background": "https://is1-ssl.mzstatic.com/image/thumb/Music122/v4/e8/47/e4/e847e492-2c31-bea2-2753-d725e4024bbc/pr_source.png/800x800cc.jpg",
      "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/23/95/9b/23959b6c-7cab-d838-4e62-5700dd11ef6a/886449666904.jpg/400x400cc.jpg",
      "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/23/95/9b/23959b6c-7cab-d838-4e62-5700dd11ef6a/886449666904.jpg/400x400cc.jpg",
      "joecolor": "b:0c0307p:fa9247s:d98440t:cb763aq:b06a35"
    }
  }
]
```

</details>

<details><summary><b>Top Charts by genre</b></summary>
```json
[
  {
    "layout": "5",
    "type": "MUSIC",
    "key": "675031499",
    "title": "greedy",
    "subtitle": "Tate McRae",
    "share": {
      "subject": "greedy - Tate McRae",
      "text": "greedy by Tate McRae",
      "href": "https://www.shazam.com/track/675031499/greedy",
      "image": "https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/1b/9a/d3/1b9ad377-0346-7c99-bbdd-6dbbaf0d1107/196871542654.jpg/400x400cc.jpg",
      "twitter": "I used @Shazam to discover greedy by Tate McRae.",
      "html": "https://www.shazam.com/snippets/email-share/675031499?lang=en&country=GB",
      "avatar": "https://is1-ssl.mzstatic.com/image/thumb/AMCArtistImages126/v4/74/a1/57/74a15767-5217-7879-4653-77228e1a7875/420699b5-ed1e-4d6d-ade7-7cf50ff93f99_ami-identity-11b6c33ddb521791b7ba1dd8c4dcf764-2023-12-08T04-31-43.953Z_cropped.png/800x800cc.jpg",
      "snapchat": "https://www.shazam.com/partner/sc/track/675031499"
    },
    "images": {
      "background": "https://is1-ssl.mzstatic.com/image/thumb/AMCArtistImages126/v4/74/a1/57/74a15767-5217-7879-4653-77228e1a7875/420699b5-ed1e-4d6d-ade7-7cf50ff93f99_ami-identity-11b6c33ddb521791b7ba1dd8c4dcf764-2023-12-08T04-31-43.953Z_cropped.png/800x800cc.jpg",
      "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/1b/9a/d3/1b9ad377-0346-7c99-bbdd-6dbbaf0d1107/196871542654.jpg/400x400cc.jpg",
      "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music116/v4/1b/9a/d3/1b9ad377-0346-7c99-bbdd-6dbbaf0d1107/196871542654.jpg/400x400cc.jpg",
      "joecolor": "b:222423p:f1f0f6s:e49783t:c7c7ccq:bd8070"
    },
    "hub": {
      "type": "APPLEMUSIC",
      "image": "https://images.shazam.com/static/icons/hub/web/v5/applemusic.png",
      "actions": [
        {
          "name": "apple",
          "type": "applemusicplay",
          "id": "1716103127"
        },
        {
          "name": "apple",
          "type": "uri",
          "uri": "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview116/v4/e5/57/42/e5574282-62ba-222f-d7e6-632d6563a57e/mzaf_5618521591563245693.plus.aac.p.m4a"
        }
      ],
      "options": [
        {
          "caption": "OPEN",
          "actions": [
            {
              "name": "hub:applemusic:deeplink",
              "type": "applemusicopen",
              "uri": "https://music.apple.com/gb/album/greedy/1716102849?i=1716103127&mttnagencyid=s2n&mttnsiteid=125115&mttn3pid=Apple-Shazam&mttnsub1=Shazam_web&mttnsub2=5348615A-616D-3235-3830-44754D6D5973&itscg=30201&app=music&itsct=Shazam_web"
            },
            {
              "name": "hub:applemusic:deeplink",
              "type": "uri",
              "uri": "https://music.apple.com/gb/album/greedy/1716102849?i=1716103127&mttnagencyid=s2n&mttnsiteid=125115&mttn3pid=Apple-Shazam&mttnsub1=Shazam_web&mttnsub2=5348615A-616D-3235-3830-44754D6D5973&itscg=30201&app=music&itsct=Shazam_web"
            }
          ],
          "beacondata": {
            "type": "open",
            "providername": "applemusic"
          },
          "image": "https://images.shazam.com/static/icons/hub/web/v5/overflow-open-option.png",
          "type": "open",
          "listcaption": "Open in Apple Music",
          "overflowimage": "https://images.shazam.com/static/icons/hub/web/v5/applemusic-overflow.png",
          "colouroverflowimage": false,
          "providername": "applemusic"
        }
      ],
      "explicit": true,
      "displayname": "APPLE MUSIC"
    },
    "artists": [
      {
        "alias": "tate-mcrae",
        "id": "42",
        "adamid": "1446365464"
      }
    ],
    "url": "https://www.shazam.com/track/675031499/greedy",
    "highlightsurls": {},
    "properties": {}
  },
  {
    "layout": "5",
    "type": "MUSIC",
    "key": "45389104",
    "title": "Мой мармеладный (Я не права)",
    "subtitle": "Katya Lel",
    "share": {
      "subject": "Мой мармеладный (Я не права) - Katya Lel",
      "text": "Мой мармеладный (Я не права) by Katya Lel",
      "href": "https://www.shazam.com/track/45389104/%D0%BC%D0%BE%D0%B9-%D0%BC%D0%B0%D1%80%D0%BC%D0%B5%D0%BB%D0%B0%D0%B4%D0%BD%D1%8B%D0%B9-%D1%8F-%D0%BD%D0%B5-%D0%BF%D1%80%D0%B0%D0%B2%D0%B0",
      "image": "https://is1-ssl.mzstatic.com/image/thumb/Music1/v4/e2/73/c4/e273c424-3305-6aeb-9032-378b7a1c384f/cover.jpg/400x400cc.jpg",
      "twitter": "I used @Shazam to discover Мой мармеладный (Я не права) by Katya Lel.",
      "html": "https://www.shazam.com/snippets/email-share/45389104?lang=en&country=GB",
      "avatar": "https://is1-ssl.mzstatic.com/image/thumb/Features124/v4/91/03/9a/91039a62-28f5-af22-2145-39c1743b4def/pr_source.png/800x800cc.jpg",
      "snapchat": "https://www.shazam.com/partner/sc/track/45389104"
    },
    "images": {
      "background": "https://is1-ssl.mzstatic.com/image/thumb/Features124/v4/91/03/9a/91039a62-28f5-af22-2145-39c1743b4def/pr_source.png/800x800cc.jpg",
      "coverart": "https://is1-ssl.mzstatic.com/image/thumb/Music1/v4/e2/73/c4/e273c424-3305-6aeb-9032-378b7a1c384f/cover.jpg/400x400cc.jpg",
      "coverarthq": "https://is1-ssl.mzstatic.com/image/thumb/Music1/v4/e2/73/c4/e273c424-3305-6aeb-9032-378b7a1c384f/cover.jpg/400x400cc.jpg",
      "joecolor": "b:fff5f9p:010000s:3c1f0dt:343131q:634a3c"
    }
  }
]
```

</details>

### License
This project is licensed under the MIT License - see the LICENSE file for details.
