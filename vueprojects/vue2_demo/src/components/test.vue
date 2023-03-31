<template>
  <div>
    <table v-for="(list,index) in table" :key="index">
      <tr>
        <th>id</th>
        <th>BookName</th>
        <th>ISBN</th>
      </tr>
      <tr>
        <td>{{ list.id }}</td>
        <td>{{ list.bookName }}</td>
        <td>{{ list.isbn }}</td>
      </tr>
    </table>
    <el-button type="primary">主要按钮</el-button>
  </div>
</template>

<script>

export default {
  name: "test",
  data() {
    return {
      table: [{
        id: '',
        bookName: '',
        isbn: ''
      }],
    }
  },
  mounted() {
    this.getBookList();
  },
  methods: {
    getBookList() {
      this.axios.get("/books").then((response) => {
        this.table = response.data.data;
      })
    }
  }
}
</script>

<style scoped>

</style>
