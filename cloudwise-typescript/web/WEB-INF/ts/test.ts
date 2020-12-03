interface Person{
    name: string;
    age: number;
}

function greeter(person: Person): string{
    return "名字：${person.name}，年龄：${person.age}";
}

console.log(greeter({name:"123",age:1}))