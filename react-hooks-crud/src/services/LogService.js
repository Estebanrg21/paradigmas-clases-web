import http from "../http-common";
const getAll = () => {
 return http.get("/logs");
};

const LogDataService = {
    getAll
};

export default LogDataService;