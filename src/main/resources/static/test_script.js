const QuestionItem = {
    props: ['question'],
    template:
        `<tr>
            <td>{{ question.id }}</td>
            <td>{{ question.text }}</td>
            <td>
                <input v-model="question.answer" placeholder="print your answer">
            </td>
        </tr>`
}

const Form = {
    data() {
        return {
            title: null,
            questions: null,
            answers: null
        }
    },
    methods: {
        sendAnswers() {
            const answersSet = {
                answers: []
            };
            // this.answers = this.questions;
            // this.questions.forEach(question =>
            //     answersSet.push(1));
            // this.answers = answersSet;

            this.questions.forEach(question =>
                answersSet.answers.push({
                    questionId: question.id,
                    text: question.answer
                }));
            axios
                .post("http://localhost:8080/api/forms/1/answers", answersSet);
        }
    },
    components: {
        QuestionItem
    },
    mounted() {
        axios
            .get("http://localhost:8080/api/forms/1")
            .then(response => {
                this.title = response.data.name;
                this.questions = response.data.questions;
            })
    }
}

const app = Vue.createApp(Form)

app.mount('#form-app')
