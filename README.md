# TenderManagement
This work is intended to solve current manual Tender Management into building a new Online Tender Management System that's works for all.
## SYSTEM DESIGN
In our proposed design, we have structured the roles of users in eTendering into distinct modules. This approach allows for encapsulation of functions specific to each user role, ensuring flexibility for integration with existing interdepartmental workflows. The system consists of several main modules, including technical support (database) for archiving information and a web service module for facilitating data transfer over an Intranet. Additionally, we have modules dedicated to the typical roles in e-Tendering, such as tenderers, tenderees, and general users. Notably, the backend processes are modeled in the evaluator module and committee module, which are responsible for managing the tendering processes once bids are received. These backend processes, still predominantly manual in many existing e-Tendering systems, can be replaced or enhanced by the automated functionalities provided by the evaluator and committee modules. Currently, while the eTendering workflow at the backend is overseen by human users, these modules serve as ICT support to facilitate online interaction and communication in determining the winners and distributing the jobs. In the future, as the workflow between the frontend and backend processes becomes fully automated, these modules can be further extended with software agent technology and trading rules, ultimately achieving a more advanced scenario. The system architecture of our proposed Web-based Tendering System (WTS) encompasses the fundamental functions of the core modules.

#### Modules
- Tenderee: Module for tenderees to create and manage tender requirements.
- Tenderer: Module for tenderers to submit their offers and bids.
- Evaluators: Module for evaluating and scoring tender offers.
- Committee: Module for managing the tendering process and selecting winners.

This application is based on the research paper "Design of a web-based tendering system for e-Government procurement" (link: https://www.researchgate.net/publication/221547680_Design_of_a_web-based_tendering_system_for_e-Government_procurement).


