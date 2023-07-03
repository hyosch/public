import { ref } from 'vue';

export default function () {
  const members = ref(null);

  const getData = async () => {
    try {
      let data = await fetch('http://localhost:8080/rest/all-member');
      if (!data.ok) {
        throw Error('fetch data failure');
      }
      members.value = await data.json();
    } catch (error) {
      throw Error(error);
    }
  };

  return { members, getData };
}
