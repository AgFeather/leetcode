--Please write a SQL query to output movies with an odd numbered ID and a description that is not 'boring'. Order the result by rating.
select *
from cinema
where id%2=1 and description <> "boring"
order by rating DESC
