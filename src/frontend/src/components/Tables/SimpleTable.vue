<template>
  <div>
    <md-table v-model="list" :table-header-color="tableHeaderColor">
      <md-table-row id="md-table-list" slot="md-table-row" slot-scope="{ item }" v-on:click="getBoardDetail(item.boardNo)">
        <md-table-cell md-label="번호" >{{ item.boardNo }}</md-table-cell>
        <md-table-cell md-label="제목" >{{ item.boardTitle }}</md-table-cell>
      </md-table-row>
      <md-table-pagination md-label="페이지" :md-page-options="false" :md-page-size="10" :md-total="totalCount" />
    </md-table>
<!--    <b-table-->
<!--        id="my-table"-->
<!--        :items="list"-->
<!--        :per-page="10"-->
<!--        :current-page="page"-->
<!--        small-->
<!--    ></b-table>-->
<!--    <b-pagination-->
<!--        v-model="page"-->
<!--        :total-rows="totalCount"-->
<!--        :per-page="10"-->
<!--        :size="sm"-->
<!--        aria-controls="md-table-list"-->
<!--    ></b-pagination>-->
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
    }
  },
  data() {
    return {
      list: [],
      page: 1,
      length: 10,
      totalCount: 0
    };
  },
  methods: {
    getBoardList(page){
      axios.get("/boards", {
        params : {
          start: page,
          length: 10
        }
      }).then(response => {
        this.list = response.data.list;
        this.totalCount = response.data.count;
        console.log(this.list);
        console.log(this.totalCount);
        console.log('ReTest')
      })
      .catch(error => {
        console.log('***** Error Log : ', error);
      });
    },
    getBoardDetail(boardNo){
      console.log('>>> click event');
      console.log(boardNo);
    },
    goToNext(){
      console.log('>>> goToNext Event')
      this.page ++;
      this.getBoardList(this.page)
    }
  },
  created() {
    this.getBoardList(1);
  }
};
</script>
