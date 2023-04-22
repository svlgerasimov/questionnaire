const answersApp = {
    data() {
        return {
            title: null,
            questions: null,
            answersSets: null
        }
    },
    mounted() {
        axios
            .get("http://localhost:8080/api/forms/1")
            .then(response => {
                this.title = response.data.name;
                this.questions = response.data.questions;
            });
        axios
            .get("http://localhost:8080/api/forms/1/answers")
            .then(response => {
                this.answersSets = response.data;
            });
    }
}

Vue.createApp(answersApp).mount('#formAnswers')