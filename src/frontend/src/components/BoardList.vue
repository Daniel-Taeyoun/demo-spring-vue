<template>
  <div>
    <b-table
        striped hover
        id="pagination-table"
        :per-page="perPage"
        :current-page="currentPage"
        :items="boards"
        :fields="fields" ></b-table>
    <b-pagination
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        align="center"
        aria-controls="pagination-table"></b-pagination>
  </div>
</template>

<script>
import axios from 'axios';
import data from "@/data";

export default {
  name: 'BoardList',
  data: () => {
    let boards = data.Content.sort((a, b) => {
      return b.content_id - a.content_id;
    });
    boards = boards.map(contentItem => {
      return {
        ...contentItem,
        user_name: data.User.filter(
            userItem => userItem.user_id === contentItem.user_id
        )[0].name
      };
    });
    return {
      currentPage: 1,
      perPage: 10,
      totalCount: 0,
      fields: [
        {
          key: "content_id",
          label: "글번호"
        },
        {
          key: "title",
          label: "제목"
        },
        {
          key: "created_at",
          label: "등록일"
        },
        {
          key: "user_name",
          label: "글쓴이"
        }
      ],
      boards: boards
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
        this.totalCount = response.data.count;
      })
      .catch(error => {
        console.log('***** Error Log : ', error);
      });
    }
  },
  computed: {
    rows() {
      return this.boards.length;
    }
  }
  // created() {
  //   this.getBoardList(this.currentPage);
  // }
}
</script>