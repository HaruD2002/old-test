select o.ID as 'OrderID',
o.OrderDate,
(od.Quantity * od.SalePrice *(1-od.Discount))
as TotalAmount
from Orders o 
inner join OrderDetails od 
on o.ID = od.OrderID
where (od.Quantity * od.SalePrice *(1-od.Discount)) >8000
order by TotalAmount desc 