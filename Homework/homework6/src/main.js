import { createApp } from "vue";
import App from "./App.vue";
import { routes } from "./library/route";

import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap";

import { library } from "@fortawesome/fontawesome-svg-core";
import {
  faCameraRetro,
  faTrashCan,
  faPenToSquare,
  faMagnifyingGlass,
  faPlus,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(
  faCameraRetro,
  faTrashCan,
  faPenToSquare,
  faMagnifyingGlass,
  faPlus
);

createApp(App)
  .use(routes)
  .component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");
