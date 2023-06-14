let num = 1;
let questionItem = "lalala";
let data = [
    {questionNum:num , questionItem:questionItem }
];
data.push(
    {questionNum:++num , questionItem:questionItem }
)
console.log(data);