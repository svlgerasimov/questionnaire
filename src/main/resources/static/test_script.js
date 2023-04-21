

var app = new Vue({
    el: '#app',
    data() {
        return {
            message: null
        }
    },
    mounted() {
        axios
            .get("http://localhost:8080/api/forms/1")
            .then(response => (this.message = response.data.name))
    }
})