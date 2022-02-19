<template>
  <div>
    <md-table v-model="boards" :table-header-color="tableHeaderColor">
      <md-table-row slot="md-table-row" slot-scope="{ item }" v-on:click="getBoardDetail(item.boardNo)">
        <md-table-cell md-label="번호" >{{ item.boardNo }}</md-table-cell>
        <md-table-cell md-label="제목" >{{ item.boardTitle }}</md-table-cell>
      </md-table-row>
    </md-table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "simple-table",
  props: {
    tableHeaderColor: {
      type: String,
      default: "",
    },
  },
  data() {
    return {
      boards: [],
    };
  },
  methods: {
    getBoardList(){
      axios.get("/boards/list").then(response => {
        this.boards = response.data;
        console.log(this.boards);
      })
    },
    getBoardDetail(boardNo){
      console.log('>>> click event');
      console.log(boardNo);
    }
  },
  mounted() {
    this.getBoardList();
  }
};
</script>
