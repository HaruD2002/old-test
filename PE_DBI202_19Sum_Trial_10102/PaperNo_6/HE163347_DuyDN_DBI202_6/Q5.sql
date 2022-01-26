use PE_Demo_S2019


with Result as (
select Quantity , DENSE_RANK() 
over (Order by Quantity desc) as ranks from OrderDetails
)

select  p.ID,p.ProductName, o.Quantity
from Product p inner join OrderDetails o
on p.ID = o.ProductID
where Result = 1
order  by Quantity desc