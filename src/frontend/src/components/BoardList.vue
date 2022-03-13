<template>
  <div>
    <b-table striped hover :items="boards"></b-table>
  </div>
<!--  <div>-->
<!--    <b-table striped hover v-for="(boardNo, boardTitle) in boards" :fields="fields"></b-table>-->
<!--  </div>-->
</template>

<script>
import axios from 'axios'

export default {
  name: 'BoardList',
  data: () => {
    return {
      fields: ['No', '제목'],
      boards: [],
      items: [
        { age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
        { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        { age: 89, first_name: 'Geneva', last_name: 'Wilson' },
        { age: 38, first_name: 'Jami', last_name: 'Carney' }
      ]
    }
  },
  methods: {
    getBoardList(page){
      axios.get("/boards", {
        params : {
          start: page,
          length: 10
        }
      }).then(response => {
        this.boards = response.data.list;
        // this.totalCount = response.data.count;
        console.log(this.items[0]);
        console.log(this.boards[0]);
        console.log(this.boards[0].boardTitle);
        console.log(this.boards[0].getBoardTitle);
      })
      .catch(error => {
        console.log('***** Error Log : ', error);
      });
    }
  },
  created() {
    this.getBoardList(1);
  }
}
</script>