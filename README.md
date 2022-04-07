# TenderManagement
This work is intended to solve current manual Tender Management into building a new Online Tender Management System that's works for all.
## SYSTEM DESIGN
In our proposed design, we modeled the roles of users in eTendering into individual modules. The idea is that the functions
that belong to each user role are encapsulated on their own,making the design flexible to be integrate with existing interdepartment workflows. There are several main modules that roughly can be classified as the technical support – database that archive all the information, and web service module that facilities data passing over an Intranet. The other modules go by the typical roles in e-Tendering such as tenderers, tenderees, and general
users. In particular, the backend processes are modeled in evaluator module and committee module which are meant for 
managing the tendering processes after the bids are received. These backend processes in most existing e-Tendering systems are
still conducted manually. In our design, the committee module and the evaluator module are there to either
replace or accomplish these manual works that depends on how far the workflows get automated. At present, while the eTendering workflow at the backend is still managed by human users, the modules serve as ICT supports to facilitate online interaction / communication in deciding the winners and how jobs
should be distributed. In the future, when the workflow that couples the frontend and the backend processes become fully automated, the modules could be extended with software agent technology and trading rules – that would ultimately achieve a scenario The system architecture of our proposed WTS The
fundamental functions of the core modules are discussed below.
### Modules
- Tenderee
- Tenderer
- Evalutors
- Committee
