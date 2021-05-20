using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

#nullable disable

namespace CompanyApi.Models
{
    [Table("employee")]
    [Index(nameof(DepartmentId), Name = "DepartmentId")]
    [Index(nameof(ManagerId), Name = "ManagerId")]
    public partial class Employee
    {
        public Employee()
        {
            Subordinate = new HashSet<Employee>();
        }

        [Key]
        [Column(TypeName = "int(11)")]
        public int EmployeeId { get; set; }
        [StringLength(15)]
        public string FirstName { get; set; }
        [StringLength(15)]
        public string LastName { get; set; }
        [Column(TypeName = "int(11)")]
        public int? ManagerId { get; set; }
        public decimal? Salary { get; set; }
        public decimal? Bonus { get; set; }
        [Column(TypeName = "int(11)")]
        public int? DepartmentId { get; set; }

        [ForeignKey(nameof(DepartmentId))]
        [InverseProperty("Employees")]
        public virtual Department Department { get; set; }
        [ForeignKey(nameof(ManagerId))]
        [InverseProperty(nameof(Employee.Subordinate))]
        public virtual Employee Manager { get; set; }
        [InverseProperty(nameof(Employee.Manager))]
        public virtual ICollection<Employee> Subordinate { get; set; }
    }
}
