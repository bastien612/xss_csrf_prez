import { RecipeService } from './../../../../shared/services/recipe-service/recipe.service';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-recipes',
  templateUrl: './edit-recipes.component.html',
  styleUrls: ['./edit-recipes.component.scss']
})
export class EditRecipesComponent {
  recipeForm: FormGroup = this.formBuilder.group({
    title: [''],
    body: ['']
  });

  constructor(
    private formBuilder: FormBuilder,
    private recipeService: RecipeService,
    private router: Router
  ) {}

  onSubmit() {
    console.log('Save : ', this.recipeForm.value);
    this.recipeService
      .createRecipe(this.recipeForm.value.title, this.recipeForm.value.body)
      .subscribe(
        () => {
          this.recipeService
            .updateList()
            .subscribe(() => this.router.navigateByUrl('/recipe'));
        },
        error => {
          // tslint:disable-next-line: quotemark
          console.log("Erreur lors de la création d'une recette :", error);
          alert(`Echec lors de la créationd d'une recette : ${error}`);
        }
      );
  }
}
