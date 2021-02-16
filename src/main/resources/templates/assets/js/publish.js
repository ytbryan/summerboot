const title = document.getElementById("title");
const imageURL = document.getElementById("imageURL");
const content = document.getElementById("content");
const btnPublish = document.getElementById("btnPublish");
let titleTextarea = null;

//////////////////////////////////////////////////////////////
// Title editor
//////////////////////////////////////////////////////////////

const editStart = () => {
  // Edit mode
  titleTextarea = document.createElement("textarea");
  titleTextarea.className = "edit";
  titleTextarea.style.fontSize = "30px";
  titleTextarea.value = title.innerHTML;
  title.replaceWith(titleTextarea);
  titleTextarea.focus();

  // Preview mode
  titleTextarea.addEventListener("keydown", previewText);
  titleTextarea.addEventListener("blur", editEnd);
};

title.addEventListener("click", editStart);

const previewText = (event) => {
  if (event.key == "Enter") {
    titleTextarea.blur();
  }
};

const editEnd = () => {
  title.innerHTML = titleTextarea.value;
  titleTextarea.replaceWith(title);
};

//////////////////////////////////////////////////////////////
// Title editor - Medium editor library
//////////////////////////////////////////////////////////////

const elements = document.querySelectorAll(".editable");

const editor = new MediumEditor(elements, {
  buttonLabels: "fontawesome",
  autoLink: true,

  placeholder: {
    text: "Share your story...",
  },

  toolbar: {
    buttons: [
      "bold",
      "italic",
      "anchor",
      {
        name: "h1",
        action: "append-h2",
        aria: "header type 1",
        tagNames: ["h2"],
        contentDefault: "<b>H1</b>",
        classList: ["custom-class-h1"],
        attrs: {
          "data-custom-attr": "attr-value-h1",
        },
      },
      {
        name: "h2",
        action: "append-h3",
        aria: "header type 2",
        tagNames: ["h3"],
        contentDefault: "<b>H2</b>",
        classList: ["custom-class-h2"],
        attrs: {
          "data-custom-attr": "attr-value-h2",
        },
      },
      "quote",
    ],
  },
});

//////////////////////////////////////////////////////////////
// Submit data to backend
//////////////////////////////////////////////////////////////

const submitPost = async () => {
  alert("submitting");

  const url = "https://kai-summerboot.herokuapp.com/post/new";

  const request = {
    method: "POST",
    mode: "cors",
    credentials: "include",
    headers: {
      Accept: "application/json",
      "Content-type": "application/json",
      "Access-Control-Allow-Origin": "*",
    },

    //make sure to serialize your JSON body
    body: JSON.stringify({
      title: title,
      content: content,
      imageURL: imageURL,
    }),
  };

  fetch(url, request)
    .then((response) => response.json())
    .then((response) => {
      console.log(response);
      return response;
    })
    // Display error otherwise
    .catch((error) => {
      console.log(`Request failed: ${error}`);
    });

  // Convert data to JSON
  //   if (response.ok) {
  //     const json = await response.json();
  //     console.log(json);
  //     return json;
  //   }
  //
};

btnPublish.addEventListener("click", submitPost);

///////////////////////////////////////////////////////////////////////////////////////////////////////////
// Fetch attempt 5 - https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api?hl=en
///////////////////////////////////////////////////////////////////////////////////////////////////////////

const btnSubmit = document.getElementById("btnSubmit");

const validateResponse = (response) => {
  if (!response.ok) {
    throw Error(response.statusText);
  }
  console.log(`Response: ${response}`);
  return response;
};

const readJSONResponse = (response) => {
  console.log(`Response as JSON: ${response.json()}`);
  return response.json();
};

const logResult = (data) => {
  console.log(data);
};

const logError = (error) => {
  console.log(error);
};

const fetchJSON = async () => {
  const postTitle = title.textContent;
  const postImage = imageURL.value;
  const postContent = content.textContent;

  const url = "https://kai-summerboot.herokuapp.com/post/new";
  const urlToFetch = `${url}?title=${postTitle}&imageURL=${postImage}&content=${postContent}`;

  const data = { postTitle, postImage, postContent };

  const options = {
    method: "POST",
    body: JSON.stringify(data),

    // Set HTTP  request headers
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  };

  await fetch(urlToFetch, options) // Returns response object as promise
    .then(validateResponse) // Check if response status 200-299
    .then(readJSONResponse) // Returns promise as JSON data
    .then(logResult)
    .catch(logError);
};

btnSubmit.addEventListener("click", fetchJSON);

//////////////////////////////////////////////////////////////
// Fetch attempt 4
//////////////////////////////////////////////////////////////

// const submitForm = () => {
//   const postTitle = title.textContent;
//   const postImage = imageURL.value;
//   const postContent = content.textContent;

//   const urlToFetch = `${url}?title=${postTitle}&imageURL=${postImage}&content=${postContent}`;

// let data = {
//   title: postTitle,
//   content: postContent,
//   imageURL: postImage,
// };

//   // Calling a fetch() returns a Response object as a promise
// fetch(urlToFetch, {
//   method: "POST",
//   body: JSON.stringify(data),

//   // Set HTTP  request headers
//   headers: {
//     Accept: "application/json",
//     "Content-Type": "application/json",
//   },
// })
//     .then((response) => {
//       // Check if content type is JSON
//       const contentType = response.headers.get("content-type");

//       if (!contentType || !contentType.includes("application/json")) {
//         throw new TypeError("Oops, we haven't got JSON!");
//       }

//       // Check if response status OK
//       if (!response.ok) {
//         throw Error(response.statusText);
//       }

//       // Read response as JSON
//       return response.json();
//     })
//     .then((data) => {
//       console.log(`Success: ${data}`);
//     })
//     .catch((error) => {
//       console.log(`Fetch error ${error}`);
//     });
// };

// btnSubmit.addEventListener("click", submitForm);

// Handle HTTP status 200-299
// if (response.ok) {
//   // Get response body as JSON
//   const result = await response.json();
//   console.log(result);
//   return result;

//   // Handle network error
// } else {
//   const error = new Error(response.statusText);
//   console.log(error);
//   console.log(response.status);
// }
